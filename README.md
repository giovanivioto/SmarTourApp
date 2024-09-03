# FIAP - 2º SEMESTRE DE 2024 - TDSOR
SmarTour Android App

Este é um exemplo de aplicativo Android que obtém o IP atual do dispositivo e usa o serviço IPGeolocation para obter informações sobre a localização, como cidade e país. O projeto foi desenvolvido usando Kotlin e faz uso da biblioteca OkHttp para realizar chamadas HTTP.

## Funcionalidade

- **Obtenção do IP:** O aplicativo utiliza o serviço IPify para obter o IP público do dispositivo.
- **Consulta de Localização:** Com o IP obtido, o aplicativo faz uma solicitação ao serviço IPGeolocation para obter informações detalhadas sobre a localização do IP.

## Requisitos

- Android Studio
- Kotlin
- Chave API gratuita do IPGeolocation

## Configuração do Projeto

### 1. Obter a Chave API do IPGeolocation

Para utilizar o IPGeolocation, você precisa obter uma chave API gratuita. Siga estes passos para obter sua chave:

1. Acesse [IPGeolocation.io](https://ipgeolocation.io/).
2. Crie uma conta gratuita clicando em "Sign Up" ou "Get Started".
3. Confirme seu e-mail e faça login na sua conta.
4. No painel de controle, localize a seção de chaves API e copie sua chave API gratuita.

### 2. Configurar o Projeto no Android Studio

Clone este repositório ou crie um novo projeto Android no Android Studio e substitua o código existente pelos arquivos fornecidos.

#### 1. Dependências

No arquivo `build.gradle` (módulo: app), adicione as seguintes dependências:

```groovy
plugins {
    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
}

android {
    namespace 'com.example.ipgeolocation'
    compileSdk 33

    defaultConfig {
        applicationId "com.example.ipgeolocation"
        minSdk 21
        targetSdk 33
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    implementation "org.jetbrains.kotlin:kotlin-stdlib:1.8.20"
    implementation 'androidx.core:core-ktx:1.10.1'
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'com.google.android.material:material:1.9.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    implementation 'com.squareup.okhttp3:okhttp:5.0.0-alpha.11'
    implementation 'com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.11'
}