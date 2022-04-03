package com.example.realjavacode;

import com.example.realjavacode.model.*;
import com.example.realjavacode.service.EligibilityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.OffsetDateTime;
import java.util.List;

@SpringBootApplication
@Slf4j
public class RealjavacodeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(RealjavacodeApplication.class, args);

		EligibilityService eligibilityService = run.getBean(EligibilityService.class);
		ProductOfferingQualificationRequest productOfferingQualificationRequest;
		productOfferingQualificationRequest = new ProductOfferingQualificationRequest(OffsetDateTime.now(),"family", List.of( RelatedChannel.builder().code("123").label("lable").build()),
				List.of(ProductOfferingQualficationItemRequest.builder()
						.action(ProductActionType.modify)
						.effectiveDate(OffsetDateTime.now())
						.expirtionDate(OffsetDateTime.now())
						.product(ProductRefOrValueRequest.builder()
								.id("123456789")
								.productType("subscription")
								.relatedparty(List.of(RelatedParty.builder().id("123456789").name("related party").role(Role.CUSTOMER).build())).build())
						.productOfferingQualificationItem(List.of(ProductOfferingQualficationItemRequest.builder().action(ProductActionType.add).product(ProductRefOrValueRequest.builder()
								.id("123456789")
								.productType("subscription")
								.relatedparty(List.of(RelatedParty.builder().id("123456789").name("related party").role(Role.CUSTOMER).build())).build()).expirtionDate(OffsetDateTime.now()).effectiveDate(OffsetDateTime.now()).build())).build()));
		ProductOfferingQulaification productOfferingQulaification = eligibilityService.validateProductOfferQualification(productOfferingQualificationRequest,"ref12345","req123456","ovc");
		log.info("ProductOfferingQulaification:"+productOfferingQulaification);
	}

}
