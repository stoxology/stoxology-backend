
package stoxology.datacollator.alchemy.entities;

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
    "status",
    "usage",
    "url",
    "totalTransactions",
    "language",
    "publicationDate",
    "docSentiment",
    "keywords"
})
public class AlchemyCombined {

    @JsonProperty("status")
    private String status;
    @JsonProperty("usage")
    private String usage;
    @JsonProperty("url")
    private String url;
    @JsonProperty("totalTransactions")
    private String totalTransactions;
    @JsonProperty("language")
    private String language;
    @JsonProperty("publicationDate")
    private PublicationDate publicationDate;
    @JsonProperty("docSentiment")
    private DocSentiment docSentiment;
    @JsonProperty("keywords")
    private List<Keyword> keywords = new ArrayList<Keyword>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The status
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The usage
     */
    @JsonProperty("usage")
    public String getUsage() {
        return usage;
    }

    /**
     * 
     * @param usage
     *     The usage
     */
    @JsonProperty("usage")
    public void setUsage(String usage) {
        this.usage = usage;
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
     *     The totalTransactions
     */
    @JsonProperty("totalTransactions")
    public String getTotalTransactions() {
        return totalTransactions;
    }

    /**
     * 
     * @param totalTransactions
     *     The totalTransactions
     */
    @JsonProperty("totalTransactions")
    public void setTotalTransactions(String totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    /**
     * 
     * @return
     *     The language
     */
    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    /**
     * 
     * @param language
     *     The language
     */
    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * 
     * @return
     *     The publicationDate
     */
    @JsonProperty("publicationDate")
    public PublicationDate getPublicationDate() {
        return publicationDate;
    }

    /**
     * 
     * @param publicationDate
     *     The publicationDate
     */
    @JsonProperty("publicationDate")
    public void setPublicationDate(PublicationDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    /**
     * 
     * @return
     *     The docSentiment
     */
    @JsonProperty("docSentiment")
    public DocSentiment getDocSentiment() {
        return docSentiment;
    }

    /**
     * 
     * @param docSentiment
     *     The docSentiment
     */
    @JsonProperty("docSentiment")
    public void setDocSentiment(DocSentiment docSentiment) {
        this.docSentiment = docSentiment;
    }

    /**
     * 
     * @return
     *     The keywords
     */
    @JsonProperty("keywords")
    public List<Keyword> getKeywords() {
        return keywords;
    }

    /**
     * 
     * @param keywords
     *     The keywords
     */
    @JsonProperty("keywords")
    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
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
