package com.example.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.example.model.error.InvalidDecrementException;
import org.junit.jupiter.api.Test;

class AliasSizeTest {

  @Test
  void AliasSizeを1で生成したオブジェクトをインクリメントして返ってきたオブジェクトがAliasSizeを2で生成したオブジェクトと同値になる() {
    assertThat(AliasSize.of(1).increment()).isEqualTo(AliasSize.of(2));
  }

  @Test
  void AliasSizeを1で生成したオブジェクトをデクリメントして返ってきたオブジェクトがAliasSizeを0で生成したオブジェクトと同値になる() {
    assertThat(AliasSize.of(1).decrement()).isEqualTo(AliasSize.of(0));
  }

  @Test
  void AliasSizeを0で生成したオブジェクトをデクリメントすると例外が発生する() {
    assertThrows(InvalidDecrementException.class, () -> AliasSize.of(0).decrement());
  }

  @Test
  void valueがマイナス1のとき例外が発生する() {
    assertThrows(IllegalArgumentException.class, () -> AliasSize.of(-1).validate());
  }

  @Test
  void valueが0のとき例外が発生しない() {
    assertDoesNotThrow(() -> AliasSize.of(0).validate());
  }
}
