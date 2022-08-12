package refactoredmobileplans.mobileplansfactory;

import refactoredmobileplans.Data1_5GB;
import refactoredmobileplans.Data2GB;
import refactoredmobileplans.Talktime30;
import refactoredmobileplans.MobilePlan;
import refactoredmobileplans.PlanName;

public class MobilePlansFactory {
  public static MobilePlan getMobilePlanForName(PlanName name) {
    switch (name) {
      case Data1_5GB:
        return new Data1_5GB();
        case Data2GB:
        return new Data2GB();
      case Talktime30:
        return new Talktime30();
      default:
        return null;
    }
  }
}