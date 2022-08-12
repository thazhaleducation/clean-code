package refactoredmobileplans;

public class Data1_5GB extends MobilePlan{

  @Override
  public PlanName getName() {
    return PlanName.Data1_5GB;
  }
  @Override
  public Integer getRechargeAmount() {
    return 500;
  }

  @Override
  public Integer getValidity() {
    return 28;
  }

  @Override
  public String getDataSpeed() {
    return "1Mbps";
  }
}
