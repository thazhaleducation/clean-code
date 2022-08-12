package mobileplans;

public class MobilePlans {
  public Integer getRechargeAmount(String planName) {
    switch (planName) {
      case "Data1_5GB":
        return 500;
      case "Data2GB":
        return 650;
      case "Talktime30":
        return 30;
      default:
        return 0;
    }
  }

  public Integer getValidity(String planName) {
    switch (planName) {
      case "Data1_5GB":
        return 28;
      case "Data2GB":
        return 30;
      case "Talktime30":
        return -1;
      default:
        return 0;
    }
  }

  public String getDataSpeed(String planName) {
    switch (planName) {
      case "Data1_5GB":
        return "1Mbps";
      case "Data2GB":
        return "1.5Mbps";
      case "Talktime30":
        return "Invalid";
      default:
        return "";
    }
  }
}