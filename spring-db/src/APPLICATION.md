アプリケーション演習
---

Java アプリケーションからデータベースに接続する演習をします。
なお、 jdbc については別途勉強してください。

アプリケーションの実行
---

トップディレクトリーで次を実装してください

```shell
# トップディレクトリーから次を実行
./gradlew spring-db:runApp
```

---

演習
---

現在、次の実装をしています。これらの実装を参考にして、次の実装を導いてください。

* `users` テーブルからの全データ取得 SQL
* `users` + `user_token` への新規データ追加

なお結果は、 `CommandLineRunner` の中で表示してください

1. `aliases` テーブルからユーザーを指定してレコードを取得する(パラメーターは次の通り)
  * `userId`
  * 次の値を取得してください
    * `userId`
    * `name`
    * `value`
1. `aliases` テーブルへの新規レコードの追加(パラメーターは次の通り)
  * `userId` - `long`
  * `name` - `String`
  * `value` - `String`

