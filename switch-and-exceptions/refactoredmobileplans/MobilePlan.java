package refactoredmobileplans;

public abstract class MobilePlan {
  public abstract Integer getRechargeAmount();
  public abstract Integer getValidity();
  public abstract String getDataSpeed();
  public abstract PlanName getName();

  public String display() {
    return String.format("Plan: %s - Amount: %d - Validity in days: %d - Speed: %s", getName(), getRechargeAmount(), getValidity(), getDataSpeed());
  }
}
