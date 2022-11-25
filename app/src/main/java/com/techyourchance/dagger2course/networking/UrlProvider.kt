package com.techyourchance.dagger2course.networking

import com.techyourchance.dagger2course.Constants

class UrlProvider {
    fun getBaseUrl(): String = Constants.BASE_URL
    fun getBaseUrl2(): String = "base_url"
}
