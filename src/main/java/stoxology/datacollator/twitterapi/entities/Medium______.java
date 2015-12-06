
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
    "id",
    "id_str",
    "indices",
    "media_url",
    "media_url_https",
    "url",
    "display_url",
    "expanded_url",
    "type",
    "sizes",
    "source_status_id",
    "source_status_id_str",
    "source_user_id",
    "source_user_id_str"
})
public class Medium______ {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("id_str")
    private String idStr;
    @JsonProperty("indices")
    private List<Integer> indices = new ArrayList<Integer>();
    @JsonProperty("media_url")
    private String mediaUrl;
    @JsonProperty("media_url_https")
    private String mediaUrlHttps;
    @JsonProperty("url")
    private String url;
    @JsonProperty("display_url")
    private String displayUrl;
    @JsonProperty("expanded_url")
    private String expandedUrl;
    @JsonProperty("type")
    private String type;
    @JsonProperty("sizes")
    private Sizes___ sizes;
    @JsonProperty("source_status_id")
    private Long sourceStatusId;
    @JsonProperty("source_status_id_str")
    private String sourceStatusIdStr;
    @JsonProperty("source_user_id")
    private Integer sourceUserId;
    @JsonProperty("source_user_id_str")
    private String sourceUserIdStr;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The idStr
     */
    @JsonProperty("id_str")
    public String getIdStr() {
        return idStr;
    }

    /**
     * 
     * @param idStr
     *     The id_str
     */
    @JsonProperty("id_str")
    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    /**
     * 
     * @return
     *     The indices
     */
    @JsonProperty("indices")
    public List<Integer> getIndices() {
        return indices;
    }

    /**
     * 
     * @param indices
     *     The indices
     */
    @JsonProperty("indices")
    public void setIndices(List<Integer> indices) {
        this.indices = indices;
    }

    /**
     * 
     * @return
     *     The mediaUrl
     */
    @JsonProperty("media_url")
    public String getMediaUrl() {
        return mediaUrl;
    }

    /**
     * 
     * @param mediaUrl
     *     The media_url
     */
    @JsonProperty("media_url")
    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    /**
     * 
     * @return
     *     The mediaUrlHttps
     */
    @JsonProperty("media_url_https")
    public String getMediaUrlHttps() {
        return mediaUrlHttps;
    }

    /**
     * 
     * @param mediaUrlHttps
     *     The media_url_https
     */
    @JsonProperty("media_url_https")
    public void setMediaUrlHttps(String mediaUrlHttps) {
        this.mediaUrlHttps = mediaUrlHttps;
    }

    /**
     * 
     * @return
     *     The url
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The displayUrl
     */
    @JsonProperty("display_url")
    public String getDisplayUrl() {
        return displayUrl;
    }

    /**
     * 
     * @param displayUrl
     *     The display_url
     */
    @JsonProperty("display_url")
    public void setDisplayUrl(String displayUrl) {
        this.displayUrl = displayUrl;
    }

    /**
     * 
     * @return
     *     The expandedUrl
     */
    @JsonProperty("expanded_url")
    public String getExpandedUrl() {
        return expandedUrl;
    }

    /**
     * 
     * @param expandedUrl
     *     The expanded_url
     */
    @JsonProperty("expanded_url")
    public void setExpandedUrl(String expandedUrl) {
        this.expandedUrl = expandedUrl;
    }

    /**
     * 
     * @return
     *     The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The sizes
     */
    @JsonProperty("sizes")
    public Sizes___ getSizes() {
        return sizes;
    }

    /**
     * 
     * @param sizes
     *     The sizes
     */
    @JsonProperty("sizes")
    public void setSizes(Sizes___ sizes) {
        this.sizes = sizes;
    }

    /**
     * 
     * @return
     *     The sourceStatusId
     */
    @JsonProperty("source_status_id")
    public Long getSourceStatusId() {
        return sourceStatusId;
    }

    /**
     * 
     * @param sourceStatusId
     *     The source_status_id
     */
    @JsonProperty("source_status_id")
    public void setSourceStatusId(Long sourceStatusId) {
        this.sourceStatusId = sourceStatusId;
    }

    /**
     * 
     * @return
     *     The sourceStatusIdStr
     */
    @JsonProperty("source_status_id_str")
    public String getSourceStatusIdStr() {
        return sourceStatusIdStr;
    }

    /**
     * 
     * @param sourceStatusIdStr
     *     The source_status_id_str
     */
    @JsonProperty("source_status_id_str")
    public void setSourceStatusIdStr(String sourceStatusIdStr) {
        this.sourceStatusIdStr = sourceStatusIdStr;
    }

    /**
     * 
     * @return
     *     The sourceUserId
     */
    @JsonProperty("source_user_id")
    public Integer getSourceUserId() {
        return sourceUserId;
    }

    /**
     * 
     * @param sourceUserId
     *     The source_user_id
     */
    @JsonProperty("source_user_id")
    public void setSourceUserId(Integer sourceUserId) {
        this.sourceUserId = sourceUserId;
    }

    /**
     * 
     * @return
     *     The sourceUserIdStr
     */
    @JsonProperty("source_user_id_str")
    public String getSourceUserIdStr() {
        return sourceUserIdStr;
    }

    /**
     * 
     * @param sourceUserIdStr
     *     The source_user_id_str
     */
    @JsonProperty("source_user_id_str")
    public void setSourceUserIdStr(String sourceUserIdStr) {
        this.sourceUserIdStr = sourceUserIdStr;
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
