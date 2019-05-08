package com.example.infrastructure;

import com.example.dao.AliasDao;
import com.example.dao.UserDao;
import com.example.dao.UserTokenDao;
import com.example.dao.entity.AliasDataView;
import com.example.dao.entity.UserDataView;
import com.example.dao.entity.UserEntity;
import com.example.dao.entity.UserTokenEntity;
import com.example.model.Alias;
import com.example.model.AliasPage;
import com.example.model.AliasSize;
import com.example.model.AppException;
import com.example.model.ErrorType;
import com.example.model.User;
import com.example.model.UserId;
import com.example.model.UserName;
import com.example.model.UserRepository;
import com.example.model.UserToken;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.seasar.doma.jdbc.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserRepositoryImpl implements UserRepository {

  @NotNull
  private final UserDao userDao;
  private final UserTokenDao userTokenDao;
  private final AliasDao aliasDao;

  private final Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);

  @Contract(pure = true)
  public UserRepositoryImpl(@NotNull final UserDao userDao, @NotNull final UserTokenDao userTokenDao, @NotNull final AliasDao aliasDao) {
    this.userDao = userDao;
    this.userTokenDao = userTokenDao;
    this.aliasDao = aliasDao;
  }

  @Override
  public Optional<User> findById(final @NotNull UserId userId) {
    return userDao.findUserById(userId)
        .map(UserDataView::toUser);
  }

  @Override
  public Optional<User> findByName(final @NotNull UserName userName) {
    Optional<User> user = userDao.findUserByName(userName)
            .map(UserDataView::toUser);
    if (user.isEmpty()) {
      throw new AppException(ErrorType.NO_RESOURCE, "user is not found.");
    } else {
      return user;
    }
  }

  @Override
  public Optional<User> createUser(final User user) {
    Result<UserEntity> userEntityResult = userDao.insertUser(new UserEntity(user.userId, user.name, user.createdAt));
    Result<UserTokenEntity> tokenEntityResult = userTokenDao.insertUserToken(new UserTokenEntity(user.userId, user.token, user.createdAt));

    return Optional.of(user);
  }

  @Override
  public Optional<User> updateUserToken(final @NotNull User user, final@NotNull UserToken userToken) {
    Result<UserTokenEntity> userTokenEntityResult = userTokenDao.updateUserToken(new UserTokenEntity(user.userId, userToken, user.createdAt));
    return Optional.of(user);
  }

  @Override
  public Optional<UserToken> findUserTokenByUserId(final @NotNull UserId userId) {
    return findById(userId)
            .flatMap(u -> userTokenDao.findUserTokenByUserId(u.userId))
              .map(t -> t.token);
  }

  @Override
  public void deleteUserEntity(@NotNull final UserEntity userEntity) {
    userDao.deleteUser(userEntity);
  }

  @Override
  public void deleteUserTokenEntity(@NotNull final UserTokenEntity userTokenEntity) {
    userTokenDao.deleteUserToken(userTokenEntity);
  }

  @Override
  public Optional<User> findUserByUserNameAndUserToken(@NotNull final UserName userName, @NotNull final UserToken userToken) {
    return findByName(userName).map(u -> {
      if (u.token.value().equals(userToken.value())) {
        return u;
      } else {
        throw new IllegalArgumentException("invalid token");
      }
    });
  }

  @Override
  public List<Alias> findAliasesByUserNameAndUserToken(@NotNull UserName userName, @NotNull UserToken userToken, @NotNull AliasPage aliasPage, @NotNull AliasSize aliasSize) {
    Optional<User> user = findUserByUserNameAndUserToken(userName, userToken);
    return aliasDao.findAliasesById(user.orElseThrow(() -> new IllegalArgumentException("invalid input")).userId, aliasPage, aliasSize)
              .stream()
              .map(AliasDataView::toAlias)
              .collect(Collectors.toList());
  }
}
