insert into "users"("user_id", "name", "created_at") values
  (1000, 'John', '2019-01-03 04:05:06.700'),
  (2000, 'Denny', '2019-01-04 05:06:07.800'),
  (3000, 'Paul', '2019-01-05 06:07:08.900'),
  (4000, 'Avril', '2019-01-06 07:08:09.000')
;

insert into "user_tokens"("user_id", "token", "created_at") values
  (1000, '838128c4-acb1-46ba-a3ee-4c995cb0f57c', '2019-01-03 04:05:06.700'),
  (2000, '5902e8df-a472-4bac-b164-782a0185a6ba', '2019-01-04 05:06:07.800'),
  (3000, 'f45e0620-4932-497c-b2dd-108effebb0f1', '2019-01-05 06:07:08.900'),
  (4000, 'e2452225-c753-497d-81a0-4460d0ed5c70', '2019-01-06 07:08:09.000')
;

insert into "aliases"("alias_id", "user_id", "name", "value", "created_at") VALUES
  (1010, 1000, 'vim', 'emacs', '2019-01-04 08:09:00.100'),
  (1020, 1000, 'emacs', 'vim', '2019-01-05 09:00:01.200'),
  (1030, 1000, 'll', 'ls -la', '2019-01-06 00:01:02.300'),
  (3010, 3000, 'll', 'ls -la', '2019-01-07 01:02:03.400'),
  (4010, 4000, 'll', 'ls -la', '2019-01-08 02:03:04.500'),
  (4020, 4000, 'd', 'docker run', '2019-01-09 03:04:05.600'),
  (4030, 4000, 'log', 'echo', '2019-01-10 04:05:06.700'),
  (4040, 4000, 'vir', 'virtualenv', '2019-01-11 05:06:07.800'),
  (4050, 4000, 'vim', 'emacs', '2019-01-11 05:06:07.800')
;