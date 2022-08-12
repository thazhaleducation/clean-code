package refactoredmobileplans;

import refactoredmobileplans.mobileplansfactory.MobilePlansFactory;

public class MobilePlansTester {
  public static void main(String[] args) {
    MobilePlan mobilePlans = MobilePlansFactory.getMobilePlanForName(PlanName.Data1_5GB);
    Integer amount = mobilePlans.getRechargeAmount();
    Integer validity = mobilePlans.getValidity();
    String dataSpeed = mobilePlans.getDataSpeed();
    String displayPlan = String.format("Plan: %s - Amount: %d - Validity in days: %d - Speed: %s", "Data1_5GB", amount, validity, dataSpeed);
    System.out.println(displayPlan);
  }
}
