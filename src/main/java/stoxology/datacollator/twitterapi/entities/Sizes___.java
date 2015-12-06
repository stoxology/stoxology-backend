
package stoxology.datacollator.twitterapi.entities;

import java.util.HashMap;
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
    "small",
    "large",
    "thumb",
    "medium"
})
public class Sizes___ {

    @JsonProperty("small")
    private Small___ small;
    @JsonProperty("large")
    private Large___ large;
    @JsonProperty("thumb")
    private Thumb___ thumb;
    @JsonProperty("medium")
    private Medium_______ medium;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The small
     */
    @JsonProperty("small")
    public Small___ getSmall() {
        return small;
    }

    /**
     * 
     * @param small
     *     The small
     */
    @JsonProperty("small")
    public void setSmall(Small___ small) {
        this.small = small;
    }

    /**
     * 
     * @return
     *     The large
     */
    @JsonProperty("large")
    public Large___ getLarge() {
        return large;
    }

    /**
     * 
     * @param large
     *     The large
     */
    @JsonProperty("large")
    public void setLarge(Large___ large) {
        this.large = large;
    }

    /**
     * 
     * @return
     *     The thumb
     */
    @JsonProperty("thumb")
    public Thumb___ getThumb() {
        return thumb;
    }

    /**
     * 
     * @param thumb
     *     The thumb
     */
    @JsonProperty("thumb")
    public void setThumb(Thumb___ thumb) {
        this.thumb = thumb;
    }

    /**
     * 
     * @return
     *     The medium
     */
    @JsonProperty("medium")
    public Medium_______ getMedium() {
        return medium;
    }

    /**
     * 
     * @param medium
     *     The medium
     */
    @JsonProperty("medium")
    public void setMedium(Medium_______ medium) {
        this.medium = medium;
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
