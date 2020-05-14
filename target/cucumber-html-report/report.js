$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("ECCM-46.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#language: pt"
    },
    {
      "line": 2,
      "value": "#Author: Thiago Benites"
    }
  ],
  "line": 4,
  "name": "ECCM-46",
  "description": "EU como GC QUERO que os beneficios do plano sejam alterados no front de acordo com as condições de compra selecionadas pelo usuário \nPARA que sejam apresentados os benefícios corretos por seleção do usuário \nE aumentar a conversão e ticket médio de compras da Loja Online CRITÉRIOS",
  "id": "eccm-46",
  "keyword": "Funcionalidade",
  "tags": [
    {
      "line": 3,
      "name": "@ECCM-46"
    },
    {
      "line": 3,
      "name": "@US39015"
    }
  ]
});
formatter.before({
  "duration": 12809736900,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "CT03 Alterações no Plano PLP Controle_Desk",
  "description": "",
  "id": "eccm-46;ct03-alterações-no-plano-plp-controle-desk",
  "type": "scenario",
  "keyword": "Cenario",
  "tags": [
    {
      "line": 9,
      "name": "@ECCM-46-CT03"
    },
    {
      "line": 9,
      "name": "@US39015-CT03"
    }
  ]
});
formatter.step({
  "line": 11,
  "name": "que ao acessar o site do ecommerce",
  "keyword": "Dado "
});
formatter.step({
  "line": 12,
  "name": "selecionar a regionalizacao estado \"SP\" e cidade \"SÃO PAULO\"",
  "keyword": "E "
});
formatter.match({
  "location": "ContextoSteps.queAoAcessarOSiteDoEcommerce()"
});
formatter.write("Acesso realizado com sucesso");
formatter.embedding("image/png", "embedded0.png");
formatter.result({
  "duration": 10029931100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "SP",
      "offset": 36
    },
    {
      "val": "SÃO PAULO",
      "offset": 50
    }
  ],
  "location": "HomeSteps.selecionarARegionalizacaoEstadoECidade(String,String)"
});
formatter.result({
  "duration": 54841400,
  "error_message": "org.openqa.selenium.WebDriverException: An unknown server-side error occurred while processing the command. Original error: unknown error: Unsupported locator strategy: accessibility id\n  (Session info: chrome\u003d81.0.4044.138)\n  (Driver info: chromedriver\u003d2.42.591088 (7b2b2dca23cca0862f674758c9a3933e685c27d5),platform\u003dWindows NT 10.0.18362 x86_64)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027DESKTOP-RMIBBL9\u0027, ip: \u0027192.168.0.11\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_251\u0027\nDriver info: io.appium.java_client.android.AndroidDriver\nCapabilities {browserName: Chrome, databaseEnabled: false, desired: {browserName: Chrome, deviceName: emulator-5554, platformName: android}, deviceManufacturer: Google, deviceModel: Android SDK built for x86, deviceName: emulator-5554, deviceScreenSize: 1080x1920, deviceUDID: emulator-5554, javascriptEnabled: true, locationContextEnabled: false, networkConnectionEnabled: true, platform: LINUX, platformName: Android, platformVersion: 7.0, takesScreenshot: true, warnings: {}, webStorageEnabled: false}\nSession ID: 113ed690-b3c2-440d-a846-73727239c62d\n*** Element info: {Using\u003daccessibility id, value\u003dstorefinderLocationComponentState}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat io.appium.java_client.remote.AppiumCommandExecutor.execute(AppiumCommandExecutor.java:239)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.execute(DefaultGenericMobileDriver.java:41)\r\n\tat io.appium.java_client.AppiumDriver.execute(AppiumDriver.java:1)\r\n\tat io.appium.java_client.android.AndroidDriver.execute(AndroidDriver.java:1)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElement(DefaultGenericMobileDriver.java:61)\r\n\tat io.appium.java_client.AppiumDriver.findElement(AppiumDriver.java:1)\r\n\tat io.appium.java_client.android.AndroidDriver.findElement(AndroidDriver.java:1)\r\n\tat io.appium.java_client.FindsByAccessibilityId.findElementByAccessibilityId(FindsByAccessibilityId.java:37)\r\n\tat support.DriverQAM.findElem(DriverQAM.java:351)\r\n\tat support.DriverQAM.click(DriverQAM.java:574)\r\n\tat pages.HomePage.preencheLocalizacao(HomePage.java:43)\r\n\tat steps.HomeSteps.selecionarARegionalizacaoEstadoECidade(HomeSteps.java:13)\r\n\tat ✽.E selecionar a regionalizacao estado \"SP\" e cidade \"SÃO PAULO\"(ECCM-46.feature:12)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 996981600,
  "status": "passed"
});
});