/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * aapt tool from the resource data it found.  It
 * should not be modified by hand.
 */

package org.sdsu.intelligrid;

public final class R {
    public static final class attr {
        /** <p>Must be a reference to another resource, in the form "<code>@[+][<i>package</i>:]<i>type</i>:<i>name</i></code>"
or to a theme attribute in the form "<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>".
         */
        public static final int metaButtonBarButtonStyle=0x7f010001;
        /** <p>Must be a reference to another resource, in the form "<code>@[+][<i>package</i>:]<i>type</i>:<i>name</i></code>"
or to a theme attribute in the form "<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>".
         */
        public static final int metaButtonBarStyle=0x7f010000;
    }
    public static final class color {
        public static final int black_overlay=0x7f050000;
    }
    public static final class drawable {
        public static final int background=0x7f020000;
        public static final int backgroundnight=0x7f020001;
        public static final int battery=0x7f020002;
        public static final int business1=0x7f020003;
        public static final int business1copy=0x7f020004;
        public static final int business2=0x7f020005;
        public static final int business2copy=0x7f020006;
        public static final int business2copy2=0x7f020007;
        public static final int condo=0x7f020008;
        public static final int condo2=0x7f020009;
        public static final int exit=0x7f02000a;
        public static final int faults=0x7f02000b;
        public static final int faultspage=0x7f02000c;
        public static final int graphs=0x7f02000d;
        public static final int graphspage=0x7f02000e;
        public static final int house1solar=0x7f02000f;
        public static final int house1solar2=0x7f020010;
        public static final int house1solar3=0x7f020011;
        public static final int house2solar=0x7f020012;
        public static final int house2solar2=0x7f020013;
        public static final int house2solar3=0x7f020014;
        public static final int house3=0x7f020015;
        public static final int house3copy=0x7f020016;
        public static final int house3copy2=0x7f020017;
        public static final int ic_launcher=0x7f020018;
        public static final int info=0x7f020019;
        public static final int infopage=0x7f02001a;
        public static final int intelligrid=0x7f02001b;
        public static final int midway=0x7f02001c;
        public static final int museum=0x7f02001d;
        public static final int orb=0x7f02001e;
        public static final int paths=0x7f02001f;
        public static final int pause=0x7f020020;
        public static final int play=0x7f020021;
        public static final int play2=0x7f020022;
        public static final int play3=0x7f020023;
        public static final int solarpanel=0x7f020024;
        public static final int stadium=0x7f020025;
        public static final int store=0x7f020026;
        public static final int substation=0x7f020027;
        public static final int switch1=0x7f020028;
        public static final int switch2=0x7f020029;
        public static final int switch3=0x7f02002a;
        public static final int switch4=0x7f02002b;
        public static final int switch5=0x7f02002c;
        public static final int switch6=0x7f02002d;
        public static final int tie=0x7f02002e;
        public static final int trackhoe=0x7f02002f;
        public static final int transformer=0x7f020030;
        public static final int transformer2=0x7f020031;
        public static final int transformer3=0x7f020032;
        public static final int transformer4=0x7f020033;
        public static final int transformer5=0x7f020034;
        public static final int transformer6=0x7f020035;
        public static final int turbine=0x7f020036;
        public static final int turbine2=0x7f020037;
    }
    public static final class layout {
        public static final int activity_main=0x7f030000;
    }
    public static final class raw {
        public static final int spritefrag=0x7f040000;
        public static final int spritevert=0x7f040001;
    }
    public static final class string {
        public static final int AppDesc=0x7f060003;
        public static final int app_name=0x7f060000;
        public static final int dummy_button=0x7f060001;
        public static final int dummy_content=0x7f060002;
    }
    public static final class style {
        /** 
        Base application theme, dependent on API level. This theme is replaced
        by AppBaseTheme from res/values-vXX/styles.xml on newer devices.

    

            Theme customizations available in newer API levels can go in
            res/values-vXX/styles.xml, while customizations related to
            backward-compatibility can go here.

        

        Base application theme for API 11+. This theme completely replaces
        AppBaseTheme from res/values/styles.xml on API 11+ devices.

    
 API 11 theme customizations can go here. 

        Base application theme for API 14+. This theme completely replaces
        AppBaseTheme from BOTH res/values/styles.xml and
        res/values-v11/styles.xml on API 14+ devices.
    
 API 14 theme customizations can go here. 
         */
        public static final int AppBaseTheme=0x7f070000;
        /**  Application theme. 
 All customizations that are NOT specific to a particular API-level can go here. 
         */
        public static final int AppTheme=0x7f070001;
        public static final int ButtonBar=0x7f070003;
        public static final int ButtonBarButton=0x7f070004;
        public static final int FullscreenActionBarStyle=0x7f070005;
        public static final int FullscreenTheme=0x7f070002;
    }
    public static final class styleable {
        /** 
         Declare custom theme attributes that allow changing which styles are
         used for button bars depending on the API level.
         ?android:attr/buttonBarStyle is new as of API 11 so this is
         necessary to support previous API levels.
    
           <p>Includes the following attributes:</p>
           <table>
           <colgroup align="left" />
           <colgroup align="left" />
           <tr><th>Attribute</th><th>Description</th></tr>
           <tr><td><code>{@link #ButtonBarContainerTheme_metaButtonBarButtonStyle org.sdsu.intelligrid:metaButtonBarButtonStyle}</code></td><td></td></tr>
           <tr><td><code>{@link #ButtonBarContainerTheme_metaButtonBarStyle org.sdsu.intelligrid:metaButtonBarStyle}</code></td><td></td></tr>
           </table>
           @see #ButtonBarContainerTheme_metaButtonBarButtonStyle
           @see #ButtonBarContainerTheme_metaButtonBarStyle
         */
        public static final int[] ButtonBarContainerTheme = {
            0x7f010000, 0x7f010001
        };
        /**
          <p>This symbol is the offset where the {@link org.sdsu.intelligrid.R.attr#metaButtonBarButtonStyle}
          attribute's value can be found in the {@link #ButtonBarContainerTheme} array.


          <p>Must be a reference to another resource, in the form "<code>@[+][<i>package</i>:]<i>type</i>:<i>name</i></code>"
or to a theme attribute in the form "<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>".
          @attr name org.sdsu.intelligrid:metaButtonBarButtonStyle
        */
        public static final int ButtonBarContainerTheme_metaButtonBarButtonStyle = 1;
        /**
          <p>This symbol is the offset where the {@link org.sdsu.intelligrid.R.attr#metaButtonBarStyle}
          attribute's value can be found in the {@link #ButtonBarContainerTheme} array.


          <p>Must be a reference to another resource, in the form "<code>@[+][<i>package</i>:]<i>type</i>:<i>name</i></code>"
or to a theme attribute in the form "<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>".
          @attr name org.sdsu.intelligrid:metaButtonBarStyle
        */
        public static final int ButtonBarContainerTheme_metaButtonBarStyle = 0;
    };
}
