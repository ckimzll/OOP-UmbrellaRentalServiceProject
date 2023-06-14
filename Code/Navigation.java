
import java.awt.*;
import javax.swing.*;
import java.util.*;

class Navigation extends Thread
{
	private final JLabel navlabel;
    private final JLabel iconlabel;
    private final JPanel navpanel;
    private final java.util.List<Point> targetCoordinates; // Point 객체의 리스트 -> 좌표값들
    private int curX;
    private int curY;
    private final int moveX; // x축 이동속도
    private final int moveY; // y축 이동속도
    private final int sleepTime;

	public Navigation(JLabel navlabel, JLabel iconlabel, JPanel navpanel, java.util.List<Point> targetCoordinates,
                         int startX, int startY, int moveX, int moveY, int sleepTime) {
        this.navlabel = navlabel;
        this.iconlabel = iconlabel;
        this.navpanel = navpanel;
        this.targetCoordinates = targetCoordinates;
        this.curX = startX;
        this.curY = startY;
        this.moveX = moveX;
        this.moveY = moveY;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        // icon, 경로 그리기
        for (Point targetPoint : targetCoordinates) { // targetPoint 변수-> 각 좌표 저장
            int targetX = (int) targetPoint.getX();
            int targetY = (int) targetPoint.getY();

            while (curX != targetX || curY != targetY) {
                try {
                    // x축 이동
                    if (curX < targetX) {
                        curX += moveX;
                        if (curX > targetX) {
                            curX = targetX;
                        }
                    } else if (curX > targetX) {
                        curX -= moveX;
                        if (curX < targetX) {
                            curX = targetX;
                        }
                    }

                    // y축 이동
                    if (curY < targetY) {
                        curY += moveY;
                        if (curY > targetY) {
                            curY = targetY;
                        }
                    } else if (curY > targetY) {
                        curY -= moveY;
                        if (curY < targetY) {
                            curY = targetY;
                        }
                    }

                    // icon 위치 이동
                    SwingUtilities.invokeLater(() -> {
                        iconlabel.setBounds(curX, curY, 60, 60);
                    });

                    Thread.sleep(sleepTime);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}







