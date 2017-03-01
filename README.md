# Text2Speach
语音合成，文字转语音

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        compile 'com.github.wulee510505:Text2Speach:1.0.0'
	}

Step 3. 在需要文字转语音的地方
      Text2Speech.speech(context,"text",false);
