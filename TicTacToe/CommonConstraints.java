package TicTacToe;
import java.awt.*;
public class CommonConstraints {
   public static final Color Background_Color = Color.decode("#011627");
   public static final Color X_Color = Color.decode("#E71D36");
   public static final Color O_Color =  Color.decode("#2EC486");
   public static final Color Bar_Color = Color.decode("#FF9F1C");
   public static final Color Board_Color = Color.decode("#FDFFFC");

   public static final Dimension FRAME_SIZE = new Dimension(540, 700);
   public static final Dimension BOARD_SIZE = new Dimension((int)(FRAME_SIZE.width*0.96), (int)(FRAME_SIZE.height*0.6));
   public static final Dimension Button_Size = new Dimension(100, 100);
   public static final Dimension Result_Dialog_Size = new Dimension((int)(FRAME_SIZE.width/3),(int)(FRAME_SIZE.height/6));

   public static final String Bar_Label= "Start";
   public static final String X_Label= "X";
   public static final String O_Label= "O";
   public static final String Score_Label= "X: 0 | O: 0";
}
