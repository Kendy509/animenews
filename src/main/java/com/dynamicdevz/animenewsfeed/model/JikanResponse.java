
package com.dynamicdevz.animenewsfeed.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class JikanResponse {

    @SerializedName("request_hash")
    @Expose
    private String requestHash;
    @SerializedName("request_cached")
    @Expose
    private Boolean requestCached;
    @SerializedName("request_cache_expiry")
    @Expose
    private Integer requestCacheExpiry;
    @SerializedName("results")
    @Expose
    private List<JikanResult> jikanResults = null;
    @SerializedName("last_page")
    @Expose
    private Integer lastPage;

    public String getRequestHash() {
        return requestHash;
    }

    public void setRequestHash(String requestHash) {
        this.requestHash = requestHash;
    }

    public Boolean getRequestCached() {
        return requestCached;
    }

    public void setRequestCached(Boolean requestCached) {
        this.requestCached = requestCached;
    }

    public Integer getRequestCacheExpiry() {
        return requestCacheExpiry;
    }

    public void setRequestCacheExpiry(Integer requestCacheExpiry) {
        this.requestCacheExpiry = requestCacheExpiry;
    }

    public List<JikanResult> getResults() {
        return jikanResults;
    }

    public void setResults(List<JikanResult> jikanResults) {
        this.jikanResults = jikanResults;
    }

    public Integer getLastPage() {
        return lastPage;
    }

    public void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }

}
