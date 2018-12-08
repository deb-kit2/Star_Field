import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class star_filed extends PApplet {

Star[] stars = new Star[800];
float speed;
public void setup()
{
 
 for(int i =0; i<stars.length; i++)
 {
   stars[i] = new Star();
 }
}
public void draw()
{
  speed = map(mouseX, 0, width, 0, 10);
  background(0);
  translate(width/2, height/2);
  for(int i =0; i<stars.length; i++)
 {
   stars[i].update();
   stars[i].show();
 }
}
class Star
{
  float x;
  float y;
  float z;
  float pz;

  Star()
  {
    x = random(-width, width);
    y = random(-height, height);
    z = random(width);  //set z = width
    pz = z;
  }
  
  public void update()
  {
    z-=speed;
    if (z<1)
    {
    x = random(-width, width);
    y = random(-height, height);
    z = width;
    pz = z;
    }
  }
  
  public void show()
  {
    fill(255);
    noStroke();
    float sx = map(x/z, 0, 1, 0, width);
    float sy = map(y/z, 0, 1, 0, height);
    float r = map(z, 0, width, 10, 0);
    ellipse(sx,sy,r,r);
    
    float px = map(x/pz, 0, 1, 0, width);
    float py = map(y/pz, 0, 1, 0, height);
    pz = z;
    stroke(255);
    line(px, py, sx, sy);
  }
}
  public void settings() {  size (600, 600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "star_filed" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
