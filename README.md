### Features

- Used MVVM architecture to develop this demo application

# MVVM_Sample.md

![](https://pandao.github.io/editor.md/images/logos/editormd-logo-180x180.png)

Code Blocks (Preformatted text):

#### GreetViewModel.Java　

    public class GreetViewModel extends ViewModel {
    private static final String TAG = "GreetViewModel";
    private GreetRespository greetRespository;

    public GreetViewModel() {
        greetRespository = GreetRespository.getInstance();
    }

    public LiveData<GreetMessage> getMessage() {
        return greetRespository.getMessage();
    }

    public void doGreetRequest(int time /* seconds */, String message) {
        greetRespository.doGreetRequest(time, message);
    }
	}


#### MainActivity.Java　
```java
// viewmodel
private GreetViewModel greetViewModel;
 
 private void subsribeObservers() {
        greetViewModel.getMessage().observe(this, new Observer<GreetMessage>() {
            @Override
            public void onChanged(@Nullable GreetMessage greetMessage) {
                Toast.makeText(MainActivity.this, greetMessage.getMessage(), greetMessage.getTimeDuration() * 1000).show();
            }
        });
    }

// invoke
greetViewModel.doGreetRequest(time, msg);
```

#### Build.gradle

```groov
// ViewModel and LiveData
    implementation "android.arch.lifecycle:extensions:$lifecycle_version"
```
