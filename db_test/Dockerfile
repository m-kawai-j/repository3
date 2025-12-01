# ==========================================================
# STAGE 1: ビルダー (JARファイル生成用)
# ==========================================================
FROM maven:3.9.6-eclipse-temurin-21-alpine AS builder

# 作業ディレクトリを設定
WORKDIR /app

# ソースコードをすべてコピー
# (pom.xmlがルートにない場合は、ここでパスを調整)
COPY . .

# MavenでJARファイルをビルド
# Renderのビルド環境では、-Dmaven.test.skip=trueでテストをスキップすることが推奨されます
RUN mvn clean package -DskipTests

# ==========================================================
# STAGE 2: 最終実行環境 (軽量なJREのみ)
# ==========================================================
FROM eclipse-temurin:21-jre-alpine

# 実行ユーザーを非ルートユーザーに切り替え (セキュリティ強化)
USER daemon

# ポートの公開 (Renderでは自動でポートが設定されるが、ドキュメントとして残す)
EXPOSE 8080

# STAGE 1で生成されたJARファイルをコピー
# (ワイルドカードではなく、正確なパスを使います)
COPY --from=builder /app/target/db_test-0.0.1-SNAPSHOT.jar app.jar

# 実行コマンドの設定 (Render環境変数PORTを優先)
ENTRYPOINT ["java", "-Dserver.port=${PORT}", "-jar", "/app.jar"]
