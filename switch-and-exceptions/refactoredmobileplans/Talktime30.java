package refactoredmobileplans;

public class Talktime30 implements MobilePlan{

  @Override
  public Integer getRechargeAmount() {
    return 30;
  }

  @Override
  public Integer getValidity() {
    throw new UnsupportedOperationException();
  }

  @Override
  public String getDataSpeed() {
    throw new UnsupportedOperationException();
  }
}
