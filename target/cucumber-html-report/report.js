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
  "description": "EU como GC QUERO que os beneficios do plano sejam alterados no front de acordo com as condições de compra selecionadas pelo usuário \r\nPARA que sejam apresentados os benefícios corretos por seleção do usuário \r\nE aumentar a conversão e ticket médio de compras da Loja Online CRITÉRIOS",
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
  "duration": 43841905200,
  "error_message": "org.openqa.selenium.SessionNotCreatedException: Unable to create a new remote session. Please check the server log for more details. Original error: An unknown server-side error occurred while processing the command. Original error: Could not find a connected Android device.\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027NOTE_4DFZ23\u0027, ip: \u0027192.168.0.14\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_251\u0027\nDriver info: driver.version: AndroidDriver\nremote stacktrace: UnknownError: An unknown server-side error occurred while processing the command. Original error: Could not find a connected Android device.\n    at getResponseForW3CError (C:\\Program Files\\Appium\\resources\\app\\node_modules\\appium\\node_modules\\appium-base-driver\\lib\\protocol\\errors.js:804:9)\n    at asyncHandler (C:\\Program Files\\Appium\\resources\\app\\node_modules\\appium\\node_modules\\appium-base-driver\\lib\\protocol\\protocol.js:388:37)\n    at process._tickCallback (internal/process/next_tick.js:68:7)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027NOTE_4DFZ23\u0027, ip: \u0027192.168.0.14\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_251\u0027\nDriver info: driver.version: AndroidDriver\r\n\tat io.appium.java_client.remote.AppiumCommandExecutor$1.createSession(AppiumCommandExecutor.java:208)\r\n\tat io.appium.java_client.remote.AppiumCommandExecutor.createSession(AppiumCommandExecutor.java:217)\r\n\tat io.appium.java_client.remote.AppiumCommandExecutor.execute(AppiumCommandExecutor.java:239)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.execute(DefaultGenericMobileDriver.java:41)\r\n\tat io.appium.java_client.AppiumDriver.execute(AppiumDriver.java:1)\r\n\tat io.appium.java_client.android.AndroidDriver.execute(AndroidDriver.java:1)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.startSession(RemoteWebDriver.java:213)\r\n\tat io.appium.java_client.AppiumDriver.startSession(AppiumDriver.java:336)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.\u003cinit\u003e(RemoteWebDriver.java:131)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.\u003cinit\u003e(DefaultGenericMobileDriver.java:37)\r\n\tat io.appium.java_client.AppiumDriver.\u003cinit\u003e(AppiumDriver.java:88)\r\n\tat io.appium.java_client.AppiumDriver.\u003cinit\u003e(AppiumDriver.java:98)\r\n\tat io.appium.java_client.android.AndroidDriver.\u003cinit\u003e(AndroidDriver.java:94)\r\n\tat support.DriverQAM.start(DriverQAM.java:62)\r\n\tat support.Hooks.ConfiguracaoInicial(Hooks.java:56)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\r\n\tat cucumber.runtime.Runtime.runHookIfTagsMatch(Runtime.java:224)\r\n\tat cucumber.runtime.Runtime.runHooks(Runtime.java:212)\r\n\tat cucumber.runtime.Runtime.runBeforeHooks(Runtime.java:202)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:40)\r\n\tat cucumber.runtime.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:102)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:63)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:18)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:95)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:38)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:100)\r\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:89)\r\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:41)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:542)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:770)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:464)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:210)\r\nCaused by: java.lang.reflect.InvocationTargetException\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat io.appium.java_client.remote.AppiumCommandExecutor$1.createSession(AppiumCommandExecutor.java:186)\r\n\t... 52 more\r\nCaused by: org.openqa.selenium.WebDriverException: An unknown server-side error occurred while processing the command. Original error: Could not find a connected Android device.\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027NOTE_4DFZ23\u0027, ip: \u0027192.168.0.14\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_251\u0027\nDriver info: driver.version: AndroidDriver\nremote stacktrace: UnknownError: An unknown server-side error occurred while processing the command. Original error: Could not find a connected Android device.\n    at getResponseForW3CError (C:\\Program Files\\Appium\\resources\\app\\node_modules\\appium\\node_modules\\appium-base-driver\\lib\\protocol\\errors.js:804:9)\n    at asyncHandler (C:\\Program Files\\Appium\\resources\\app\\node_modules\\appium\\node_modules\\appium-base-driver\\lib\\protocol\\protocol.js:388:37)\n    at process._tickCallback (internal/process/next_tick.js:68:7)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.W3CHandshakeResponse.lambda$errorHandler$0(W3CHandshakeResponse.java:62)\r\n\tat org.openqa.selenium.remote.HandshakeResponse.lambda$getResponseFunction$0(HandshakeResponse.java:30)\r\n\tat org.openqa.selenium.remote.ProtocolHandshake.lambda$createSession$0(ProtocolHandshake.java:126)\r\n\tat java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:193)\r\n\tat java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:958)\r\n\tat java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:126)\r\n\tat java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:499)\r\n\tat java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:486)\r\n\tat java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)\r\n\tat java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:152)\r\n\tat java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)\r\n\tat java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:464)\r\n\tat org.openqa.selenium.remote.ProtocolHandshake.createSession(ProtocolHandshake.java:128)\r\n\t... 57 more\r\n",
  "status": "failed"
});
formatter.scenario({
  "line": 10,
  "name": "CT03 Alterações no Plano PLP Controle_Mobile",
  "description": "",
  "id": "eccm-46;ct03-alterações-no-plano-plp-controle-mobile",
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
formatter.step({
  "line": 13,
  "name": "clicar em Mais detalhes no plano \"4GB\", \"CONTROLE\", \"64,99\"",
  "keyword": "E "
});
formatter.step({
  "line": 14,
  "name": "seleciona a fidelizacao \"12 meses\"",
  "keyword": "Quando "
});
formatter.step({
  "line": 15,
  "name": "validar as promoções e aplicativos",
  "keyword": "Entao "
});
formatter.step({
  "line": 16,
  "name": "seleciona a fidelizacao \"Sem fidelização\"",
  "keyword": "Quando "
});
formatter.step({
  "line": 17,
  "name": "Validar que as promoções e aplicativos foram alterados",
  "keyword": "Entao "
});
formatter.match({
  "location": "ContextoSteps.queAoAcessarOSiteDoEcommerce()"
});
formatter.result({
  "status": "skipped"
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
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "4GB",
      "offset": 34
    },
    {
      "val": "CONTROLE",
      "offset": 41
    },
    {
      "val": "64,99",
      "offset": 53
    }
  ],
  "location": "HomeSteps.clicarEmMaisDetalhesNoPlano(String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "12 meses",
      "offset": 25
    }
  ],
  "location": "DetalhesPlanoSteps.selecionaAFidelizacao(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "DetalhesPlanoSteps.validarAsPromoçõesEAplicativos()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Sem fidelização",
      "offset": 25
    }
  ],
  "location": "DetalhesPlanoSteps.selecionaAFidelizacao(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "DetalhesPlanoSteps.validarQueAsPromoçõesEAplicativosForamAlterados()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 177200,
  "status": "passed"
});
});