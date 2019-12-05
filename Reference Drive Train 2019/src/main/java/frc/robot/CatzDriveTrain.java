package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.CANSparkMax.IdleMode;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class CatzDriveTrain 
{
    private static CANSparkMax drvTrainMtrCtrlLTFrnt;
    private static CANSparkMax drvTrainMtrCtrlLTBack;
    private static CANSparkMax drvTrainMtrCtrlRTBack;
    private static CANSparkMax drvTrainMtrCtrlRTFrnt;

    private static DifferentialDrive drvTrainDifferentialDrive;

    private static SpeedControllerGroup drvTrainLT;
    private static SpeedControllerGroup drvTrainRT;

    private final int DRVTRAIN_LT_FRNT_MC_NEO_ID = 1; 
    private final int DRVTRAIN_LT_BACK_MC_NEO_ID = 2;
    private final int DRVTRAIN_RT_BACK_MC_NEO_ID = 3;
    private final int DRVTRAIN_RT_FRNT_MC_NEO_ID = 4;

    private static DoubleSolenoid gearShifter;

    private static final int DRVTRAIN_CLIMBER_SOLENOID_A_PCM_PORT_A = 0;
    private static final int DRVTRAIN_CLIMBER_SOLENOID_A_PCM_PORT_B = 1;

    private final double DRVTRAIN_RAMP_RATE = 0.25;
    private final int DRVTRAIN_MTR_CTRL_CURRENT_LIMIT = 60;

    public CatzDriveTrain ()
    {
        drvTrainMtrCtrlLTFrnt = new CANSparkMax (DRVTRAIN_LT_FRNT_MC_NEO_ID, MotorType.kBrushless);
        drvTrainMtrCtrlLTBack = new CANSparkMax (DRVTRAIN_LT_BACK_MC_NEO_ID, MotorType.kBrushless);
        drvTrainMtrCtrlRTBack = new CANSparkMax (DRVTRAIN_RT_BACK_MC_NEO_ID, MotorType.kBrushless);
        drvTrainMtrCtrlRTFrnt = new CANSparkMax (DRVTRAIN_RT_FRNT_MC_NEO_ID, MotorType.kBrushless);

        drvTrainMtrCtrlLTFrnt.setIdleMode(IdleMode.kCoast);
        drvTrainMtrCtrlLTBack.setIdleMode(IdleMode.kCoast);

        drvTrainMtrCtrlRTFrnt.setIdleMode(IdleMode.kCoast);
        drvTrainMtrCtrlRTBack.setIdleMode(IdleMode.kCoast);

        drvTrainMtrCtrlLTFrnt.setSmartCurrentLimit(DRVTRAIN_MTR_CTRL_CURRENT_LIMIT);
        drvTrainMtrCtrlLTBack.setSmartCurrentLimit(DRVTRAIN_MTR_CTRL_CURRENT_LIMIT);

        drvTrainMtrCtrlRTFrnt.setSmartCurrentLimit(DRVTRAIN_MTR_CTRL_CURRENT_LIMIT);
        drvTrainMtrCtrlRTBack.setSmartCurrentLimit(DRVTRAIN_MTR_CTRL_CURRENT_LIMIT);

        drvTrainMtrCtrlRTBack.burnFlash();
        drvTrainMtrCtrlRTFrnt.burnFlash();
        drvTrainMtrCtrlLTBack.burnFlash();
        drvTrainMtrCtrlLTFrnt.burnFlash();

        drvTrainLT = new SpeedControllerGroup(drvTrainMtrCtrlLTFrnt, drvTrainMtrCtrlLTBack);
        drvTrainRT = new SpeedControllerGroup(drvTrainMtrCtrlRTFrnt, drvTrainMtrCtrlRTBack);

        drvTrainDifferentialDrive = new DifferentialDrive(drvTrainLT, drvTrainRT);

        gearShifter = new DoubleSolenoid(DRVTRAIN_CLIMBER_SOLENOID_A_PCM_PORT_A, DRVTRAIN_CLIMBER_SOLENOID_A_PCM_PORT_B);
    }

    public void arcadeDrive (double power, double rotation)
    {
        drvTrainDifferentialDrive.arcadeDrive(power, rotation, true); // ,true?
    }

    public void deployGearShift()
    {
        gearShifter.set(Value.kReverse);
    }

    public void retractGearShift()
    {
        gearShifter.set(Value.kForward);
    }
}