package allProjects;

public abstract class Runner {

	private boolean run;
	
	public Runner() {
		run = true;
	}
	
	@SuppressWarnings("rawtypes")
	public static void launch(String... args) {
        // Figure out the right class to call
        StackTraceElement[] cause = Thread.currentThread().getStackTrace();
        boolean foundThisMethod = false;
        String callingClassName = null;
        for (StackTraceElement se : cause) {
            // Skip entries until we get to the entry for this class
            String className = se.getClassName();
            String methodName = se.getMethodName();
            if (foundThisMethod) {
                callingClassName = className;
                break;
            } else if (Runner.class.getName().equals(className)
                    && "launch".equals(methodName)) {

                foundThisMethod = true;
            }
        }
        if (callingClassName == null) {
            throw new RuntimeException("Error: unable to determine Runner class");
        }
        try {
            Class theClass = Class.forName(callingClassName, false,
                               Thread.currentThread().getContextClassLoader());
            if (Runner.class.isAssignableFrom(theClass)) {
                Runner runner = (Runner) Class.forName(theClass.getName()).newInstance();
                try {runner.start(args);} catch (InterruptedException i) {return;}
            } else {
                throw new RuntimeException("Error: " + theClass
                        + " is not a subclass of abstract class Runner");
            }
        } catch (RuntimeException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
	
	public abstract void start(String... args) throws Exception;
	
	public final void runLoop(Object... args) {
		while(run) {
			runnable(args);
		}
	}
	
	public void runnable(Object ... args) {
		
	}
	
	
	protected final void quit() {
		run = false;
	}
	
	protected final void forceQuit() {
		quit();
		Thread.currentThread().interrupt();
	}
}
