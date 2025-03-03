// import from math.js using named import
import { add, sub, pi } from './math.js';
console.log(add(1, 2), sub(1, 2), pi);

// import from math.js using alias
import { add as sum, sub as diff } from './math.js';
console.log(sum(2, 3));

// default import from utility.js
import greet from './utility.js';
console.log(greet("Paridhi"));

// import both types without redeclaring 'add'
// import greetMath, {add(2,3), pi} from './math.js';
import greetMath from './math.js'; // only default import here

// import everything
import * as MathUtils from './math.js';
console.log(MathUtils.add(2, 6));





























