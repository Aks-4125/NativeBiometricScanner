# NativeBiometricScanner
Android BiometricPrompt introduced in Android Pie


### Before Android 9 Pie, your options to implement a fingerprint scanning dialog were:

* Build your own from scratch
* Copy Google's sample implementation
* Use some unofficial library

Unfortunately neither of those options are great. Unless of course you have really specific UI requirements and need to build your own.
But for most applications it's enough to have a generic dialog and it'd be great to have an official one.

Luckily, since Android 9 Pie, Google has introduced the BiometricPrompt that addresses this issue. 
Hopefully this post will help you integrate it.




## Using the BiometricPrompt builder we can:
```
setTitle() — Set the title to display (Required)

setSubtitle() — Set the subtitle to display (Optional)

setDescription() — Set the description to display(Optional)

setNegativeButton() — Set the text for the negative button(Required). 
```
You must also provide an Executor instance and a click listener for the negative button.


> Note: You can’t customise the icon or error message that are used within the dialog.


```
implementation 'androidx.biometric:biometric:1.0.0-alpha04'
```


There are other bio-metric detection schemes that are beginning to appear, such as more advanced facial recognition, and there are potentially others that may begin appearing soon.



## Dialog 

![Result](https://github.com/Aks-4125/NativeBiometricScanner/blob/master/app/src/main/res/raw/native_scanner.jpg)



