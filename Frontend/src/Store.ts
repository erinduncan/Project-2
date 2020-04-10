import logger from "redux-logger";
import reduxThunk from "redux-thunk";
import { state } from "./reducers";
import { applyMiddleware, Store, createStore, compose } from "redux";

const saveToLocalStorage = (state: any) => {
  try {
    const serializedState = JSON.stringify(state);
    localStorage.setItem("state", serializedState);
  } catch (e) {
    console.log(e);
  }
};

const loadFromLocalStorage = () => {
  try {
    const serializedState = localStorage.getItem("state");
    if (serializedState === null) {
      return undefined;
    }
    return JSON.parse(serializedState);
  } catch (e) {
    console.log(e);
    return undefined;
  }
};

const a: any = window;

const composeEnhancers = a.REDUX_DEVTOOLS_EXTENSION_COMPOSE || compose;
const enhancer = composeEnhancers(
  applyMiddleware(reduxThunk, logger)
);

const persistedState = loadFromLocalStorage();

export const store: Store<any> = createStore(state, persistedState, enhancer);
store.subscribe(() => saveToLocalStorage(store.getState()));
