package com.akshat.travelbankdemo.utils

import java.io.IOException

class ApiExceptions(message : String) : IOException(message)
class NoInternetException (message: String) : IOException(message)