package refactoredmobileplans;

import refactoredmobileplans.mobileplansfactory.MobilePlansFactory;

public class MobilePlansTester {
  public static void main(String[] args) {
    MobilePlan mobilePlan = MobilePlansFactory.getMobilePlanForName(PlanName.Data1_5GB);
    System.out.println(mobilePlan.display());
  }
}
