package models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "consumer_offer")
@AssociationOverrides({
        @AssociationOverride(name = "pk.consumer",
                joinColumns = @JoinColumn(name = "consumer_id")),
        @AssociationOverride(name = "pk.offer",
                joinColumns = @JoinColumn(name = "offer_id"))
})
public class Advice {
    @EmbeddedId
    private ConsumerOfferId pk = new ConsumerOfferId();
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @Enumerated(EnumType.STRING)
    private OfferStatus status;

    public ConsumerOfferId getPk() {
        return pk;
    }

    public void setPk(ConsumerOfferId pk) {
        this.pk = pk;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public OfferStatus getStatus() {
        return status;
    }

    public void setStatus(OfferStatus status) {
        this.status = status;
    }

    @Transient
    public Consumer getConsumer() {
        return getPk().getConsumer();
    }

    public void setConsumer(Consumer consumer) {
        getPk().setConsumer(consumer);
    }

    @Transient
    public Offer getOffer() {
        return getPk().getOffer();
    }

    public void setOffer(Offer offer) {
        getPk().setOffer(offer);
    }
}
