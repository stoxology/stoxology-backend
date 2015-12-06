
package stoxology.datacollator.twitterapi.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "hashtags",
    "symbols",
    "user_mentions",
    "urls",
    "media"
})
public class Entities__ {

    @JsonProperty("hashtags")
    private List<Object> hashtags = new ArrayList<Object>();
    @JsonProperty("symbols")
    private List<Object> symbols = new ArrayList<Object>();
    @JsonProperty("user_mentions")
    private List<Object> userMentions = new ArrayList<Object>();
    @JsonProperty("urls")
    private List<Url____> urls = new ArrayList<Url____>();
    @JsonProperty("media")
    private List<Medium> media = new ArrayList<Medium>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The hashtags
     */
    @JsonProperty("hashtags")
    public List<Object> getHashtags() {
        return hashtags;
    }

    /**
     * 
     * @param hashtags
     *     The hashtags
     */
    @JsonProperty("hashtags")
    public void setHashtags(List<Object> hashtags) {
        this.hashtags = hashtags;
    }

    /**
     * 
     * @return
     *     The symbols
     */
    @JsonProperty("symbols")
    public List<Object> getSymbols() {
        return symbols;
    }

    /**
     * 
     * @param symbols
     *     The symbols
     */
    @JsonProperty("symbols")
    public void setSymbols(List<Object> symbols) {
        this.symbols = symbols;
    }

    /**
     * 
     * @return
     *     The userMentions
     */
    @JsonProperty("user_mentions")
    public List<Object> getUserMentions() {
        return userMentions;
    }

    /**
     * 
     * @param userMentions
     *     The user_mentions
     */
    @JsonProperty("user_mentions")
    public void setUserMentions(List<Object> userMentions) {
        this.userMentions = userMentions;
    }

    /**
     * 
     * @return
     *     The urls
     */
    @JsonProperty("urls")
    public List<Url____> getUrls() {
        return urls;
    }

    /**
     * 
     * @param urls
     *     The urls
     */
    @JsonProperty("urls")
    public void setUrls(List<Url____> urls) {
        this.urls = urls;
    }

    /**
     * 
     * @return
     *     The media
     */
    @JsonProperty("media")
    public List<Medium> getMedia() {
        return media;
    }

    /**
     * 
     * @param media
     *     The media
     */
    @JsonProperty("media")
    public void setMedia(List<Medium> media) {
        this.media = media;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
