package com.example.realjavacode.service;

import com.example.realjavacode.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
public class Context {

    protected final ProductOfferingQualificationRequest productOfferingQualficationItemRequest;
    protected final String refId;
    protected final String requestId;
    protected final String operatorId;

    protected String billingAccountNumber;
    protected String subscriptionNumber;
    protected RequestHeaders requestHeader;
    protected ProductActionType productActionType;
    protected List<ProductOfferingQualficationItemRequest> innerProductOfferingQualficationItemRequest;

    public Optional<ProductOfferingQualficationItemRequest> getProductOfferingQualficationItems() {
      return Optional.ofNullable(productOfferingQualficationItemRequest.getProductOfferingQualficationItemRequests())
              .stream()
              .flatMap(List::stream)
              .filter(Objects::nonNull)
              .findFirst();

    }
    public  Optional<ProductRefOrValueRequest> getProductType(){
        return getProductOfferingQualficationItems().map(ProductOfferingQualficationItemRequest::getProduct);
    }
    public  String getBillingAccountNumber(){
        if(billingAccountNumber==null)
        return getProductType()
                .map(ProductRefOrValueRequest::getRelatedparty)
                .stream()
                .flatMap(List::stream)
                .filter(Objects::nonNull)
                .map(RelatedParty::getId)
                .filter(StringUtils::hasText)
                .findFirst()
                .orElse("DefaultBillingAccountNumber");
        return billingAccountNumber;
    }
    public String getSubscriberNumber(){
        if(subscriptionNumber==null)
            return getProductType()
                    .map(ProductRefOrValueRequest::getId)
                    .stream()
                    .filter(StringUtils::hasText)
                    .findFirst()
                    .orElse("default subscriber");
            return subscriptionNumber;
    }

    public RequestHeaders getRequestHeader(){
        if(requestHeader == null)
            return RequestHeaders.builder()
                    .franchise(productOfferingQualficationItemRequest.getRealm())
                    .requestId(requestId)
                    .applicationId(productOfferingQualficationItemRequest.getChannel()
                            .stream()
                            .map(RelatedChannel::getCode)
                            .findFirst().orElse("deafultchannel"))
                    .build();
            return requestHeader;
    }

    public ProductActionType getProductActionType() {
        if(productActionType==null)
            return getProductOfferingQualficationItems()
                    .map(ProductOfferingQualficationItemRequest::getAction)
                    .orElse(null);

        return productActionType;
    }
    public String getFirstProductProductType(){
        return getProductOfferingQualficationItems()
                .map(ProductOfferingQualficationItemRequest::getProduct)
                .map(ProductRefOrValueRequest::getProductType).orElse("default product type");
    }
    public List<ProductOfferingQualficationItemRequest> getProductOfferingQualficationItemRequest(){
        if(innerProductOfferingQualficationItemRequest==null)
            innerProductOfferingQualficationItemRequest = getProductOfferingQualficationItems()
                    .map(ProductOfferingQualficationItemRequest::getProductOfferingQualificationItem)
                    .orElse(Collections.emptyList());
            return innerProductOfferingQualficationItemRequest;
    }

    public String findInnerProductType(){
        return getProductOfferingQualficationItemRequest().stream()
                .filter(Objects::nonNull)
                .map(ProductOfferingQualficationItemRequest::getProduct)
                .filter(Objects::nonNull)
                .findFirst()
                .map(ProductRefOrValueRequest::getProductType)
                .orElse("default product type");
    }


}
