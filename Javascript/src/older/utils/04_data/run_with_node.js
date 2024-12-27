// load dependencies
// eslint-disable-next-line no-undef
const {...events}=require("./code/load")("code/journal.js", "code/chapter/04_data.js");

for (let event of events.journalEvents(JOURNAL)) {
  let correlation = events.phi(event.tableFor(event, JOURNAL));
  if (correlation > 0.1 || correlation < -0.1) {
    console.log(event + ":", correlation);
  }
}
// → brushed teeth: -0.3805211953
// → work:          -0.1371988681
// → reading:        0.1106828054
