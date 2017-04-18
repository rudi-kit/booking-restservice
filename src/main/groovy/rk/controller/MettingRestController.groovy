package rk.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import rk.dao.MeetingDao
import rk.dto.MeetingDto
import rk.entity.Meeting
import rk.entity.User
import rk.service.MeetingService

import static org.springframework.web.bind.annotation.RequestMethod.POST

@RestController
@RequestMapping(value = '/meeting')
class MettingRestController {

    @Autowired
    MeetingService service;

    @Autowired
    MeetingDao dao

    @RequestMapping(value = "/maxless")
    Meeting getMaxLess(@RequestBody Meeting dto){
        dao.findMaxPrevious(dto)
    }

    @RequestMapping(value = "/minbigger")
    Meeting getMinBigger(@RequestBody Meeting dto){
        dao.findMinFollowing(dto)
    }

    @RequestMapping
    List<Meeting> getList(){
        service.findAll()
    }

    @RequestMapping(value = "/{id}")
    Meeting getById(@PathVariable long id){
        service.getById(id)
    }
    @RequestMapping(method = POST)
    Meeting createMeeting(@RequestBody Meeting dto){
        service.create(dto)
    }
}