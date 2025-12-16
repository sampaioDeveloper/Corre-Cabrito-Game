import java.awt.*;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


// A singleton JFrame window that provides a slider to control the volume
// of a given Java Sound Clip.
 
public class VolumeControl extends JFrame implements Elements{
    private JPanel panel;
    // Singleton instance to ensure only one volume control window exists.
    private static VolumeControl screen = null;

    private Clip audioClip;
    private FloatControl gainControl;

    private VolumeControl(Clip clip){
        super();
        this.audioClip = clip;
        // Get the gain control from the clip to manage volume.
        if (this.audioClip != null) {
            this.gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
        }
        configurarJanela();
        bg_panel();
        repaint();
    }

    public static VolumeControl getInstance(Clip clip){
        if (screen == null){
            screen = new VolumeControl(clip);
        }

        return screen;
    }

    
    // Configures the main properties of the JFrame window.
    private void configurarJanela(){
        setTitle("CorreCabrito - Controle de volume");
        setSize(450, 240);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        setVisible(true);
    }

    
    // Sets up the background panel and adds the UI components.
    private void bg_panel(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 450, 340);
        panel.setBackground(new Color(50,50,50));


        JLabel volume_label = new JLabel();
        volume_label.setText("Mudar valor do volume: ");
        volume_label.setForeground(Color.WHITE);
        volume_label.setFont(new Font("Arial", Font.PLAIN, 18));
        volume_label.setBounds(20, 30, 400, 80);

        JSlider slider = new JSlider();
        slider.setMaximum(100);
        slider.setMinimum(0);
        slider.setBounds(20, 120, 400, 25);
        slider.setBackground(new Color(50,50,50));

        // Set the initial slider position based on the clip's current volume.
        if (gainControl != null) {
            float minGain = gainControl.getMinimum();
            float maxGain = gainControl.getMaximum();
            float currentGain = gainControl.getValue();
            // Map the current gain value (e.g., -80.0f to 6.0f) to the slider's 0-100 scale.
            int sliderValue = (int) (((currentGain - minGain) / (maxGain - minGain)) * 100);
            slider.setValue(sliderValue);
        }

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e){
                JSlider source = (JSlider) e.getSource();
                // Update volume only when the user has finished dragging the slider.
                if (!source.getValueIsAdjusting()){
                    if (gainControl != null) {
                        float sliderValue = source.getValue();
                        // Map the slider's 0-100 value back to the gain control's range.
                        float minGain = gainControl.getMinimum(); // e.g., -80.0f
                        float maxGain = gainControl.getMaximum();
                        float newGain = minGain + (sliderValue / 100.0f) * (maxGain - minGain);
                        gainControl.setValue(newGain);
                    }
                }
            }
        });

        panel.add(slider);
        panel.add(volume_label);

        
        add(panel);
    }
}