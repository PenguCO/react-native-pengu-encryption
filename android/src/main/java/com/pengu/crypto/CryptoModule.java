
package com.pengu.crypto;

import com.facebook.react.bridge.NoSuchKeyException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.bridge.Promise;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class CryptoModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public CryptoModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "Crypto";
  }

  @ReactMethod
  public void encrypt(String message, String publicKeyString, Promise promise)  {

      try {
          RSA rsa = new RSA();
          rsa.setPublicKey(publicKeyString);
          String encodedMessage = rsa.encrypt(message);
          promise.resolve(encodedMessage);
      } catch(Exception e) {
          promise.reject("Error", e.getMessage());
      }
  }

  @ReactMethod
  public void encrypt64(String message, String publicKeyString, Promise promise)  {

      try {
          RSA rsa = new RSA();
          rsa.setPublicKey(publicKeyString);
          String encodedMessage = rsa.encrypt64(message);
          promise.resolve(encodedMessage);
      } catch(Exception e) {
          promise.reject("Error", e.getMessage());
      }
  }


  @ReactMethod
  public void decrypt(String encodedMessage, String privateKeyString, Promise promise)  {

      try {
          RSA rsa = new RSA();
          rsa.setPrivateKey(privateKeyString);
          String message = rsa.decrypt(encodedMessage);
          promise.resolve(message);

      } catch(Exception e) {
          promise.reject("Error", e.getMessage());
      }
  }

  @ReactMethod
  public void decrypt64(String encodedMessage, String privateKeyString, Promise promise)  {

      try {
          RSA rsa = new RSA();
          rsa.setPrivateKey(privateKeyString);
          String message = rsa.decrypt64(encodedMessage);
          promise.resolve(message);

      } catch(Exception e) {
          promise.reject("Error", e.getMessage());
      }
  }

    @ReactMethod
    public void sign(String message, String privateKeyString, Promise promise)  {

        try {
            RSA rsa = new RSA();
            rsa.setPrivateKey(privateKeyString);
            String signature = rsa.sign(message);
            promise.resolve(signature);

        } catch(Exception e) {
            promise.reject("Error", e.getMessage());
        }
    }

    @ReactMethod
    public void sign64(String message, String privateKeyString, Promise promise)  {

        try {
            RSA rsa = new RSA();
            rsa.setPrivateKey(privateKeyString);
            String signature = rsa.sign64(message);
            promise.resolve(signature);

        } catch(Exception e) {
            promise.reject("Error", e.getMessage());
        }
    }

    @ReactMethod
    public void verify(String signature, String message, String publicKeyString, Promise promise)  {

        try {
            RSA rsa = new RSA();
            rsa.setPublicKey(publicKeyString);
            boolean verified = rsa.verify(signature, message);
            promise.resolve(verified);

        } catch(Exception e) {
            promise.reject("Error", e.getMessage());
        }
    }

    @ReactMethod
    public void verify64(String signature, String message, String publicKeyString, Promise promise)  {

        try {
            RSA rsa = new RSA();
            rsa.setPublicKey(publicKeyString);
            boolean verified = rsa.verify64(signature, message);
            promise.resolve(verified);

        } catch(Exception e) {
            promise.reject("Error", e.getMessage());
        }
    }



}