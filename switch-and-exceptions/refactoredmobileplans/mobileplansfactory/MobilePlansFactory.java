package refactoredmobileplans.mobileplansfactory;

import refactoredmobileplans.Data1_5GB;
import refactoredmobileplans.Data2GB;
import refactoredmobileplans.Talktime30;
import refactoredmobileplans.MobilePlan;

public class MobilePlansFactory {
  public static MobilePlan getMobilePlanForName(String planName) {
    switch (planName) {
      case "Data1_5GB":
        return new Data1_5GB();
        case "Data2GB":
        return new Data2GB();
      case "Talktime30":
        return new Talktime30();
      default:
        return null;
    }
  }
}