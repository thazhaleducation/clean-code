package refactoredmobileplans;

public class Data2GB extends MobilePlan{

  @Override
  public Integer getRechargeAmount() {
    return 650;
  }

  @Override
  public Integer getValidity() {
    return 30;
  }

  @Override
  public String getDataSpeed() {
    return "1.5Mbps";
  }

  @Override
  public PlanName getName() {
    return PlanName.Data2GB;
  }
}
