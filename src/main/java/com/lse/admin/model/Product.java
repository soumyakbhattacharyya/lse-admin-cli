package com.lse.admin.model;

import java.time.LocalDate;

import org.apache.poi.ss.usermodel.Cell;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product implements Comparable<Product> {

  /**
   * internal id generated by the app
   */
  private String id;

  /**
   * externally provided code; typically generated by the administration team
   */
  private int code;

  private String type;

  private String description;

  /**
   * price at which the product has been bought
   */
  private double buyUnitPrice;

  /**
   * price at which the product has been planned to be sold
   */
  private double suggestedUnitPrice;

  private boolean reordered;

  private boolean replaced;

  private String supplierId;

  @JsonSerialize(using = IonLocalDateSerializer.class)
  @JsonDeserialize(using = IonLocalDateDeserializer.class)
  private LocalDate createdOn;
  private String createdBy;

  @JsonSerialize(using = IonLocalDateSerializer.class)
  @JsonDeserialize(using = IonLocalDateDeserializer.class)
  private LocalDate updatedOn;
  private String updatedBy;

  private ProductStatus productStatus;

  private String buyerName;

  private String buyerCellNumber;

  /**
   * price at which the product has been sold
   */
  private double soldAt;

  private double fifteenPercentDiscount;
  private double twentyFivePercentDiscount;
  private double thirtyPercentDiscount;

  private double numberOfInstallments;

  private double currentInstallmentNumber;

  private double currentInstallmentAmount;

  private double recoveredAmount;

  private double remainingAmount;

  private double profit;

  private double adminComponentFromProfit;

  private double sellerComponentFromProfit;

  private double travelComponentFromProfit;

  private double ITComponentFromProfit;

  private double logisticComponentFromProfit;

  private double coreGroupMemberContributionComponentFromProfit;

  public Product(String id, int code, String type, String description, double buyUnitPrice, double suggestedUnitPrice, double fifteenPercentDiscount,
      double twentyFivePercentDiscount, double thirtyPercentDiscount) {
    super();
    this.id = id;
    this.code = code;
    this.type = type;
    this.description = description;
    this.buyUnitPrice = buyUnitPrice;
    this.suggestedUnitPrice = suggestedUnitPrice;
    this.fifteenPercentDiscount = fifteenPercentDiscount;
    this.twentyFivePercentDiscount = twentyFivePercentDiscount;
    this.thirtyPercentDiscount = thirtyPercentDiscount;
  }

  @Override
  public int compareTo(Product o) {
    return this.type.compareTo(o.getType());
  }

}
