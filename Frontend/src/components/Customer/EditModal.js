import * as React from 'react';
import Button from '@mui/joy/Button';
import Modal from '@mui/joy/Modal';
import ModalClose from '@mui/joy/ModalClose';
import Typography from '@mui/joy/Typography';
import Sheet from '@mui/joy/Sheet';
import {Icon} from "@iconify/react";
import CustomerForm from "./CustomerForm";


function EditModal() {
    const [open, setOpen] = React.useState(false);
    return (
        <React.Fragment>
            <Button size='sm' color="warning" onClick={() => setOpen(true)}>
                <Icon icon="basil:edit-solid" /> </Button>
            <Modal
                variant="outlined"
                aria-labelledby="modal-title"
                aria-describedby="modal-desc"
                open={open}
                onClose={() => setOpen(false)}
                sx={{ display: 'flex', justifyContent: 'center', alignItems: 'center'}}
            >
                <Sheet size='md' sx={(theme) => ({
                    boxShadow: theme.shadow.md,
                    '--joy-shadowChannel': theme.vars.palette.warning.mainChannel,
                    '--joy-shadowRing': 'inset 0 -3px 0 rgba(0 0 0 / 0.24)',
                    padding:"20px"
                })} >
                <CustomerForm />

                </Sheet>

            </Modal>
        </React.Fragment>
    );
}

export default EditModal;