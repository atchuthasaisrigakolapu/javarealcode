package com.example.realjavacode.service;

import com.example.realjavacode.model.ProductActionType;
import com.example.realjavacode.model.ProductOfferingQualificationRequest;
import com.example.realjavacode.model.ProductOfferingQulaification;
import com.example.realjavacode.model.ProductQualificationFlow;
import org.springframework.stereotype.Service;

@Service
public class EligibilityService {

    public ProductOfferingQulaification validateProductOfferQualification(ProductOfferingQualificationRequest productOfferingQualificationRequest,String refId,String requestId,String operatorId){

        Context context = new Context(productOfferingQualificationRequest,refId,requestId,operatorId);

        switch(getProductQualificationFlow(context)){
            case CANCEL_CTN:
                //cancel_ctn flow
                return ProductOfferingQulaification.builder().build();
            case MANAGE_DISCOUNT:
                //manageDiscount flow
                return ProductOfferingQulaification.builder().build();
        }
        return null;
    }
    private ProductQualificationFlow getProductQualificationFlow(Context context){

        var action  = context.getProductActionType();
        var productType = context.getFirstProductProductType();
        String innerProductType = context.findInnerProductType();
        System.out.println("action:"+action);
        System.out.println("productType:"+productType);
        System.out.println("innerProductType"+innerProductType);
        if(ProductActionType.modify.equals(action) && "subscription".equalsIgnoreCase(productType) && "discount".equalsIgnoreCase(innerProductType))
            return ProductQualificationFlow.CANCEL_CTN;
        else if(ProductActionType.delete.equals(action) && "subscription".equalsIgnoreCase(productType))
            return ProductQualificationFlow.MANAGE_DISCOUNT;
        else
            return ProductQualificationFlow.MANAGE_DISCOUNT;//Bad request
    }


}
