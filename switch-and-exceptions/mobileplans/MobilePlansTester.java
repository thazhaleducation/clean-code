package mobileplans;

public class MobilePlansTester {
  public static void main(String[] args) {
    MobilePlans mobilePlans = new MobilePlans();
    String planName = "Data1_5GB";
    Integer amount = mobilePlans.getRechargeAmount(planName);
    Integer validity = mobilePlans.getValidity(planName);
    String dataSpeed = mobilePlans.getDataSpeed(planName);
    String displayPlan = String.format("Plan: %s - Amount: %d - Validity in days: %d - Speed: %s", planName, amount, validity, dataSpeed);
    System.out.println(displayPlan);
  }
}
