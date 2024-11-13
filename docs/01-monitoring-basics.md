# 可觀測性簡介

本章會簡介何謂可觀測性及其組成。

## Table of Contents

- [可觀測性](#可觀測性)
- [遙測資料](#遙測資料)
  - [記錄檔 Log](#記錄檔-log)
  - [指標 Metric](#指標-metric)
  - [追蹤 Trace](#追蹤-trace)
- [參考資料](#參考資料)

## 可觀測性

可觀測性 (Observability) 指的是系統、應用程式或服務可以透過其外部輸出的資訊得知其系統內部狀態，而不需事先了解該系統、應用程式或服務的實作方式。

這邊外部輸出的資訊指的其實就是記錄檔 (Logs)、指標 (Metrics) 與追蹤 (Traces) 資料，這些資料又被稱為遙測 (Telemetry) 資料

## 遙測資料

記錄檔 (Logs)、指標 (Metrics) 與追蹤 (Traces) 資料又被稱為遙測資料，也是可觀測性的三大支柱。

下面會針對這三大支柱進行簡介

### 記錄檔 Log

記錄檔又常被稱為「日誌」，在可觀測性領域中指稱的是用於紀錄系統執行過程中所發生的各項事件內容。維運人員可以透過這些紀錄檔的內容了解系統發生異常的原因，或是作為系統效能最佳化的依據。

記錄檔的歷史是遙測資料中最悠久的，但其內容格式並沒有任何規範可以遵循，因此會發現不同的應用程式其所輸出的日誌格式都不一樣，這導致實作統一的紀錄檔收集介面都必須倚賴正規表達式將資料取出，因此才有結構化日誌的出現。

對於一條標準的日誌輸出，不論其輸出的格式為何，一定會包含有以下幾項資訊:

- 事件發生的日期時間
- 事件嚴重性等級
- 事件內容描述或純文字說明

其中事件嚴重性等級較常使用以下的字樣，依據其嚴重性由輕到重排序為:

- DEBUG
- INFO
- WARN / WARNING
- ERROR
- CRITICAL

### 指標 Metric

指標指的是系統在某一時間點的狀態值，透過這樣連續的狀態值可以得知系統在某個時間點上是否遭遇效能瓶頸，並可進一步分析該校能瓶頸產生原因。

通常可觀測性後端會針對指標值過高提供相對應的告警功能，以警示維運人員目前系統特定的狀態值過高，需要注意一下

下面列出的是一些比較常見的指標:

- CPU Usage
- Memory Usage
- Disk Usage
- Request Latencies
- Error Rate
- Network Bandwidth

### 追蹤 Trace

在可觀測性中，追蹤指的是擷取並記錄應用程式執行過程的資訊，透過這些資訊，維運人員可以得知異常的請求流量執行步驟為何，以及於何處發生異常，讓相關人員可以更快速地找出問題所在，進而加速修正的時程。

其中 Trace 又由 Span 所組成，Span 是一個作業單位，有一個系統由許多服務所組成，當流量流入其中一個服務，就會產生一筆 Span 資料，資料會包含該服務名稱、開始與結束時間，處理結果、Trace ID 與 Span ID 等，透過這些資訊的組合，就可以在可觀測性後端中產生該筆請求在該系統中的行徑與相關詳細資料。

## 參考資料

- [可觀測性 - 維基百科](https://zh.wikipedia.org/zh-tw/%E5%8F%AF%E8%A7%80%E6%B8%AC%E6%80%A7)
- [Day10 - 可觀測性 Observability - iT 邦幫忙](https://ithelp.ithome.com.tw/articles/10327168)
- [記錄檔 - 維基百科](https://zh.wikipedia.org/wiki/%E6%97%A5%E5%BF%97%E6%96%87%E4%BB%B6)
- [Structured, unstructured, and semistructured logs - Logs | OpenTelemetry](https://opentelemetry.io/zh/docs/concepts/signals/logs/#structured-unstructured-and-semistructured-logs)
- [Metrics - Observability (software) - 維基百科](https://en.wikipedia.org/wiki/Observability_(software)#Metrics)
- [Day16 - Observability 介紹，Metrics、Tracing 和 Logging 是什麼？](https://ithelp.ithome.com.tw/articles/10298162)
- [Tracing (software) - 維基百科](https://en.wikipedia.org/wiki/Tracing_(software))
- [Traces | OpenTelemetry](https://opentelemetry.io/zh/docs/concepts/signals/traces/#spans)
