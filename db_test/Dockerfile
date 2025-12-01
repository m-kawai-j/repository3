# 1. ベースイメージ: Java 21の軽量なJDKイメージを使用
FROM eclipse-temurin:21-jdk-alpine

# 2. JARファイルパスの指定
ARG JAR_FILE=target/target/db_test-0.0.1-SNAPSHOT.jar

# 3. JARファイルをコンテナ内にコピー
COPY ${JAR_FILE} app.jar

# 4. ★【修正点 1】実行ユーザーを非ルートユーザーに切り替えます★
USER daemon

# 5. ★【修正点 2】実行コマンドの設定（Render環境変数を優先させる）★
# Javaコマンド実行時に、ポート設定に環境変数PORTを明示的に使用するように指定します
ENTRYPOINT ["java", "-Dserver.port=${PORT}", "-jar", "/app.jar"]

# 6. ポートの公開
EXPOSE 8080
