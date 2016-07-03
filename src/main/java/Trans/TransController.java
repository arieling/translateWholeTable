package Trans;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TransController {

    @RequestMapping(value="/trans", params = {"inpath", "outpath"}, method = RequestMethod.GET)
    public void trans(@RequestParam(value = "inpath") String inpath,
                      @RequestParam(value = "outpath") String outpath) {
        try {
            Work.writeXLSXFile(inpath, outpath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
