package refactoredmobileplans;

public class Talktime30 extends MobilePlan{

  @Override
  public Integer getRechargeAmount() {
    return 30;
  }

  @Override
  public Integer getValidity() {
    return  -1;
  }

  @Override
  public String getDataSpeed() {
    return "-";
  }

  @Override
  public PlanName getName() {
    return PlanName.Data2GB;
  }
}
