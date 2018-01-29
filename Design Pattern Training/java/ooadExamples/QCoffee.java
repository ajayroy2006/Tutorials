/* The Mark IV special makes up to 12 cups of coffee at a time.
 * The user places a filter in the filter holder, fills the filter
 * with coffee grounds, and slides the filter holder into its
 * receptacle. The user then pours up to 12 cups of water into the
 * water strainer and presses the “Brew” button. The water is heated
 * until boiling. The pressure of the evolving steam forces the water
 * to be sprayed over the coffee grounds, and coffee drips through the
 * filter into the pot. The pot is kept warm for extended periods by
 * a warmer plate, which only turns on if there is coffee in the pot.
 * If the pot is removed from the warmer plate while coffee is being
 * sprayed over the grounds, the flow of water is stopped, so that brewed
 * coffee does not spill on the warmer plate. The following hardware
 * needs to be monitored or controlled:
 *		- The heating element for the boiler. It can be turned on or off.
 *		- The heating element for the warmer plate. It can be turned on or off.
 *		- The sensor for the warmer plate. It has three states:
 *		  warmerEmpty, potEmpty, potNotEmpty.
 *		- A sensor for the boiler, which determines if there is water
 *		present or not. It has two states: boilerEmpty or boilerNotEmpty.
 *		- The brew button. This is a momentary button that starts the
 *		brewing cycle. It has an indicator that lights up when the brewing
 *		cycle is over and the coffee is ready.
 *		- A pressure-relief valve that opens to reduce the pressure in
 *		the boiler. The drop in pressure stops the flow of water to the
 *		filter. It can be opened or closed.
 * The hardware for the Mark IV has been designed and is
 * currently under development. The hardware engineers have even provided
 * a low-level API for us to use, so we don’t have to write any
 * bit-twiddling I/O driver code. The code for these interface functions
 * is mentioned below.
 */
public interface CoffeeMakerAPI {
    public static CoffeeMakerAPI api = null; // set by main.

    /**
     * This function returns the status of the warmer-plate
     * sensor. This sensor detects the presence of the pot
     * and whether it has coffee in it.
     */
    public int getWarmerPlateStatus();
    public static final int WARMER_EMPTY = 0;
    public static final int POT_EMPTY = 1;
    public static final int POT_NOT_EMPTY = 2;

    /**
     * This function returns the status of the boiler switch.
     * The boiler switch is a float switch that detects if
     * there is more than 1/2 cup of water in the boiler.
     */
    public int getBoilerStatus();
    public static final int BOILER_EMPTY = 0;
    public static final int BOILER_NOT_EMPTY = 1;

    /**
     * This function returns the status of the brew button.
     * The brew button is a momentary switch that remembers
     * its state. Each call to this function returns the
     * remembered state and then resets that state to
     * BREW_BUTTON_NOT_PUSHED.
     *
     * Thus, even if this function is polled at a very slow
     * rate, it will still detect when the brew button is
     * pushed.
     */
    public int getBrewButtonStatus();
    public static final int BREW_BUTTON_PUSHED = 0;
    public static final int BREW_BUTTON_NOT_PUSHED = 1;

    /**
     * This function turns the heating element in the boiler
     * on or off.
     */
    public void setBoilerState(int boilerStatus);
    public static final int BOILER_ON = 0;
    public static final int BOILER_OFF = 1;


    /**
     * This function turns the heating element in the warmer
     * plate on or off.
     */
    public void setWarmerState(int warmerState);
    public static final int WARMER_ON = 0;
    public static final int WARMER_OFF = 1;

    /**
     * This function turns the indicator light on or off.
     * The indicator light should be turned on at the end
     * of the brewing cycle. It should be turned off when
     * the user presses the brew button.
     */
    public void setIndicatorState(int indicatorState);
    public static final int INDICATOR_ON = 0;
    public static final int INDICATOR_OFF = 1;

    /**
     * This function opens and closes the pressure-relief
     * valve. When this valve is closed, steam pressure in
     * the boiler will force hot water to spray out over
     * the coffee filter. When the valve is open, the steam
     * in the boiler escapes into the environment, and the
     * water in the boiler will not spray out over the filter.
     */
     public void setReliefValveState(int reliefValveState);
     public static final int VALVE_OPEN = 0;
     public static final int VALVE_CLOSED = 1;
}
// Draw the class diagram. 