#include <jni.h>
#include <string>

extern "C" {
JNIEXPORT jstring
JNICALL
Java_com_lpl_test_firstndkproject_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++ 这是我写的第一句C代码，希望以后越来熟悉";
    int c=5;
    return env->NewStringUTF(hello.c_str());
}


JNIEXPORT jstring
JNICALL
Java_com_lpl_test_firstndkproject_MainActivity_stringFormJMIMtest(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "我要学JNI/NDK开发";
    return env->NewStringUTF(hello.c_str());
}
}
