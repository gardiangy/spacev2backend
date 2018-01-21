package hu.voga.space.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@AllArgsConstructor
@Getter
public enum RankType {
    
    SEAMAN_RECRUIT("Seaman Recruit","SR", "E-1"),
    SEAMAN_APPRENTICE("Seaman Apprentice","SA", "E-2"),
    SEAMAN("Seaman","SN", "E-3"),
    PETTY_OFFICER_3RD_CLASS("Petty Officer 3rd Class", "PO3", "E-4"),
    PETTY_OFFICER_2RD_CLASS("Petty Officer 2rd Class", "PO2", "E-5"),
    PETTY_OFFICER_1RD_CLASS("Petty Officer 1rd Class", "PO1", "E-6"),
    CHIEF_PETTY_OFFICER("Chief Petty Officer", "CPO", "E-7"),
    SENIOR_CHIEF_PETTY_OFFICER("Senior Chief Petty Officer","SCPO","E-8"),
    MASTER_CHIEF_PETTY_OFFICER("Master Chief Petty Officer","MCPO","E-9"),
    FLEET_COMMANDER_MASTER("Fleet / Commander Master Chief Petty Officer", "FCM","E-9a"),
    MASTER_CHIEF_PETTY_OFFICER_OF_THE_NAVY("Master Chief Petty Officer of the Navy", "MCPON", "E-9 Special"),
    CHIEF_WARRANT_OFFICER_2("Chief Warrant Officer 2", "CWO2", "W-2"),
    CHIEF_WARRANT_OFFICER_3("Chief Warrant Officer 3", "CWO3", "W-3"),
    CHIEF_WARRANT_OFFICER_4("Chief Warrant Officer 4", "CWO4", "W-4"),
    CHIEF_WARRANT_OFFICER_5("Chief Warrant Officer 5", "CWO5", "W-5"),
    ENSIGN("Ensign", "ENS", "O-1"),
    LIEUTENANT_JUNIOR_GRADE("Lieutenant Junior Grade", "LTJG", "O-2"),
    LIEUTENANT("Lieutenant", "LT", "O-3"),
    LIEUTENANT_COMMANDER("Lieutenant Commander", "LCDR", "O-4"),
    COMMANDER("Commander", "CDR", "O-5"),
    CAPTAIN("Captain", "CAPT", "O-6"),
    REAR_ADMIRAL_LOWER_HALF("Rear Admiral (Lower Half)", "RDML", "O-7"),
    REAR_ADMIRAL_UPPER_HALF("Rear Admiral (Upper Half)", "RADM", "O-8"),
    VICE_ADMIRAL("Vice Admiral", "VADM", "O-9"),
    ADMIRAL_CHIEF_OF_NAVAL("Admiral Chief of Naval", "ADM", "O-10"),
    FLEET_ADMIRAL("Fleet Admiral", "FADM", "O-11 Special");

    private String name;
    private String abbrv;
    private String grade;

}
