# Java SDK

本章節會說明如何透過 OpenTelemetry Java SDK 進行 Logs、Metrics 與 Traces 遙測資料的輸出。

## Table of Contents

## 最低需求

OpenTelemetry 針對 Java SDK 具有最低的要求

- Java 8+
  > 若是使用 Spring Boot 3，則最低要求必須具備 Java JDK 17+
- Maven 或 Gradle

## 導入 SDK

### Gradle

請參考[官方文件](https://opentelemetry.io/docs/languages/java/getting-started/#dependencies)的說明導入 SDK。

### Maven

透過 [Maven Repositories](https://mvnrepository.com/artifact/io.opentelemetry/opentelemetry-sdk) 可以找到 OpenTelemetry SDK 的儲存庫，點選對應的版本連結後，頁面會顯示安裝 SDK 所需的 XML 設定，將其複製下來後貼到專案 `pom.xml` 檔中的 `dependencies` 區塊中。

## 開始實作

### 注入 Java Agent
