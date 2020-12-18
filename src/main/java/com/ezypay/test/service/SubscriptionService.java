package com.ezypay.test.service;

import com.ezypay.test.controller.dto.SubscriptionDto;
import com.ezypay.test.controller.dto.SubscriptionType;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class SubscriptionService {



    public SubscriptionDto createSubscription(SubscriptionDto dto) {
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        if(dto.getSubscriptionType().equals(SubscriptionType.DAILY)) {

            start.set(Calendar.DAY_OF_MONTH, LocalDate.now().getDayOfMonth());
            end.set(Calendar.DAY_OF_MONTH, LocalDate.now().getDayOfMonth()+90);
            LocalDate startDate =LocalDate.parse(df.format(start.getTime()));
            LocalDate endDate =LocalDate.parse(df.format(end.getTime()));

            dto.setCreatedDate(LocalDate.now());
            dto.setStartDate(startDate);
            dto.setEndDate(endDate);
            dto.setInvoiceDate(listDate(dto.getSubscriptionType(),startDate,endDate));

            System.out.println("START " + startDate);
            System.out.println("END " + endDate);

        }else if(dto.getSubscriptionType().equals(SubscriptionType.WEEKLY)){
            System.out.println(LocalDate.now().getDayOfWeek());
            start.set(Calendar.DAY_OF_WEEK,-1);
            end.add(Calendar.WEEK_OF_YEAR,12);
            System.out.println("START " + df.format(start.getTime()));
            System.out.println("END " + df.format(end.getTime()));

            LocalDate startDate =LocalDate.parse(df.format(start.getTime()));
            LocalDate endDate =LocalDate.parse(df.format(end.getTime()));

            dto.setCreatedDate(LocalDate.now());
            dto.setStartDate(startDate);
            dto.setEndDate(endDate);
            dto.setInvoiceDate(listDate(dto.getSubscriptionType(),startDate,endDate));

        }else if(dto.getSubscriptionType().equals(SubscriptionType.MONTHLY)){
            start.set(Calendar.DAY_OF_WEEK,-1);
            end.add(Calendar.MONTH,3);
            System.out.println("START " + df.format(start.getTime()));
            System.out.println("END " + df.format(end.getTime()));
            LocalDate startDate =LocalDate.parse(df.format(start.getTime()));
            LocalDate endDate =LocalDate.parse(df.format(end.getTime()));

            dto.setCreatedDate(LocalDate.now());
            dto.setStartDate(startDate);
            dto.setEndDate(endDate);
            dto.setInvoiceDate(listDate(dto.getSubscriptionType(),startDate,endDate));
        }


        return dto;
    }

    private List<String> listDate(SubscriptionType type, LocalDate start, LocalDate end) {
        List<String> lisOfInvoiceDate = new ArrayList<>();
        if (SubscriptionType.DAILY.equals(type)) {
            while (!start.isAfter(end)) {
                lisOfInvoiceDate.add(start.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                start = start.plusDays(1);
            }
        }else if(SubscriptionType.WEEKLY.equals(type)){
            long weeks = ChronoUnit.WEEKS.between(start, end);
            for (int x = 0; x <= weeks; x++) {
                lisOfInvoiceDate.add(start.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                start = start.plusWeeks(1);
            }
        }else if(SubscriptionType.MONTHLY.equals(type)){
            long months = ChronoUnit.MONTHS.between(start, end);
            for (int x = 0; x <= months; x++) {
                lisOfInvoiceDate.add(start.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                start = start.plusMonths(1);
            }
        }

        return lisOfInvoiceDate;
    }

}
